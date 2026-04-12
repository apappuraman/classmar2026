from flask import Flask, request, render_template, jsonify
import jwt
import datetime
from functools import wraps

app = Flask(__name__)
app.config['SECRET_KEY'] = "Test123$%"


# 🔐 JWT Decorator
def token_required(f):
    @wraps(f)
    def decorated(*args, **kwargs):
        token = None

        if "Authorization" in request.headers:
            token = request.headers["Authorization"].split(" ")[1]

        if not token:
            return jsonify({"message": "Token is missing"}), 401

        try:
            data = jwt.decode(token, app.config['SECRET_KEY'], algorithms=["HS256"])
            user = data["user"]
        except:
            return jsonify({"message": "Token is invalid"}), 401

        return f(user, *args, **kwargs)

    return decorated


@app.route("/")
def index():
    return render_template("index.html")


# ✅ Login → return JWT
@app.route("/login/", methods=["POST"])
def login():
    data = request.get_json()

    username = data.get("name")
    password = data.get("password")

    # simple hardcoded validation
    if username != "admin" or password != "admin123":
        return jsonify({"message": "Invalid login"}), 401

    token = jwt.encode({
        "user": username,
        "exp": datetime.datetime.utcnow() + datetime.timedelta(minutes=30)
    }, app.config['SECRET_KEY'], algorithm="HS256")

    return jsonify({"token": token})


# ✅ Protected API
@app.route("/api/protected/")
@token_required
def protected_api(user):
    return jsonify({"message": f"Welcome {user}"})


# HTML page (NOT protected directly)
@app.route("/protected/")
def protected_page():
    return render_template("protectedpage.html")


if __name__ == "__main__":
    app.run(debug=True)
