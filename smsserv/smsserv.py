from flask import Flask, request, render_template
import sqlite3

app = Flask(__name__)

@app.route('/')
def index():
   return render_template("index.html")

@app.route('/login/')
def login():
    username=request.args.get("name")
    password=request.args.get("password")
    print("User Name:", username)
    print("password", password)
    if(username != "admin"):
        return "incorrect user name or parrword"

    if(password != "admin123"):
        return "incorrect user name or parrword"

    
    return render_template("studcreate.html", name=username)

@app.route("/studentinfo/create/")
def create():
    sname=request.args.get("name")
    sage=request.args.get("age")
    saddress=request.args.get("address")
    scity=request.args.get("city")
    spin=request.args.get("pin")
    
    # Create in-memory database
    conn = sqlite3.connect("mydb2.db")
    cursor = conn.cursor()
   
    cursor.execute("""insert into student(name, age) values( ?, ?)""", (sname, sage))

    sid = cursor.lastrowid
    cursor.execute("""insert into student_address(address, city, pin, sid) values(?, ?, ?, ?)""", (saddress, scity, spin, sid))
    conn.commit()
    conn.close()

    return render_template("studcreatesuccess.html", sid=sid)

@app.route("/studentinfo/search/")
def search():
    sid=request.args.get("id")
    conn = sqlite3.connect("mydb2.db")
    cursor = conn.cursor()

    cursor.execute("""select s.id, s.name, s.age, a.address, a.city, a.pin from student s
    join student_address a 
    on s.id=a.sid
    where s.id=?""", (sid,))
    result=cursor.fetchall()

    return render_template("studsearchresult.html", rows=result)

@app.route("/studentinfo/displaysearch/")
def displaysearch():
    return render_template("studsearch.html")

@app.route("/studentinfo/displaycreate/")
def displaycreate():
    return render_template("studcreate.html")

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
    

if __name__ == '__main__':
    init_db()
    app.run()