from flask import Flask, request, render_template, redirect, url_for, jsonify
import sqlite3
from werkzeug.security import generate_password_hash, check_password_hash
import jwt
import datetime
from functools import wraps

app = Flask(__name__)
#app.secret_key = "Test123$%" 
app.config['SECRET_KEY'] = "Test123$%"

# 🔐 JWT Token Required Decorator
def token_required(f):
    @wraps(f)
    def decorated(*args, **kwargs):
        token = None

        # Token from header
        if 'Authorization' in request.headers:
            token = request.headers['Authorization'].split(" ")[1]

        if not token:
            return jsonify({"message": "Token is missing"}), 401

        try:
            data = jwt.decode(token, app.config['SECRET_KEY'], algorithms=["HS256"])
            current_user = data['user']
        except:
            return jsonify({"message": "Token is invalid"}), 401

        return f( *args, **kwargs)

    return decorated

@app.route('/')
def index():
   return render_template("index.html")

@app.route('/login/', methods=['POST'])
def login():
    data = request.get_json()
    username = data.get("name")
    password = data.get("password")
    print("User Name:", username)
    print("password", password)
    
    conn = sqlite3.connect("mydb2.db")
    cursor = conn.cursor()

    cursor.execute("SELECT password FROM users WHERE username=?", (username,))
    row = cursor.fetchone()

    if row is None:
        return jsonify({"message": "Invalid username or password"}), 401

    stored_hash = row[0]

    if not check_password_hash(stored_hash, password):
        return jsonify({"message": "Invalid username or password"}), 401

    print(app.config['SECRET_KEY'])
    # ✅ Generate JWT token
    token = jwt.encode({
        'user': username,
        'exp': datetime.datetime.utcnow() + datetime.timedelta(minutes=30)
    }, app.config['SECRET_KEY'], algorithm="HS256")

    print("JWT Token:", token)
    return jsonify({"token": token})

@app.route("/studentinfo/displaycreate/")
def displaycreate():
    return render_template("studcreate.html")

@app.route("/studentinfo/create/", methods=['POST'])
@token_required
def create():
    data = request.get_json()

    sname = data.get("name")
    sage = data.get("age")
    saddress = data.get("address")
    scity = data.get("city")
    spin = data.get("pin")
    
    # Create in-memory database
    conn = sqlite3.connect("mydb2.db")
    cursor = conn.cursor()
   
    cursor.execute("""insert into student(name, age) values( ?, ?)""", (sname, sage))

    sid = cursor.lastrowid
    cursor.execute("""insert into student_address(address, city, pin, sid) values(?, ?, ?, ?)""", (saddress, scity, spin, sid))
    conn.commit()
    conn.close()
    print("Student ID:", sid, " created successfully")
    return jsonify({"message": "Student created", "sid": sid})

@app.route("/studentinfo/search/", methods=['GET'])
@token_required
def search():
    sid=request.args.get("id")
    conn = sqlite3.connect("mydb2.db")
    cursor = conn.cursor()

    cursor.execute("""select s.id, s.name, s.age, a.address, a.city, a.pin from student s
    join student_address a 
    on s.id=a.sid
    where s.id=?""", (sid,))
    result=cursor.fetchall()

    return jsonify(result)

@app.route("/logout/")
def logout():
    return jsonify({"message": "Logout handled on client side"})

@app.route("/studentinfo/displaysearch/")
def displaysearch():
    return render_template("studsearch.html")


def init_db():
    # Connect to database
    conn = sqlite3.connect("mydb2.db")
    cursor = conn.cursor()

    # Create student table if not exists
    cursor.execute("""
    CREATE TABLE IF NOT EXISTS student (
        id INTEGER PRIMARY KEY AUTOINCREMENT,
        name TEXT,
        age INTEGER
    )
    """)

    # Create student_address table if not exists
    cursor.execute("""
    CREATE TABLE IF NOT EXISTS student_address (
        id INTEGER PRIMARY KEY AUTOINCREMENT,
        address TEXT,
        city TEXT,
        pin INTEGER,
        sid INTEGER
    )
    """)

    conn.commit()
    conn.close()
    
def create_user():
    conn = sqlite3.connect("mydb2.db")
    cursor = conn.cursor()

    password_hash = generate_password_hash("admin123")

    cursor.execute("CREATE TABLE IF NOT EXISTS users (username TEXT, password TEXT)")
    cursor.execute("INSERT INTO users(username, password) VALUES (?, ?)", ("admin", password_hash))

    conn.commit()
    conn.close()

if __name__ == '__main__':
    init_db()
    create_user()
    app.run()

