from flask import Flask, request, render_template, redirect, make_response
import uuid

app = Flask(__name__)

# 🔥 In-memory session store (for demo)
session_store = {}


@app.route("/")
def index():
    return render_template("index.html")


@app.route("/login/", methods=["POST"])
def login():
    username = request.form.get("name")
    password = request.form.get("password")

    # Simple validation (hardcoded for demo)
    if username != "admin" or password != "admin123":
        return "Invalid login"

    # ✅ Generate session id
    session_id = str(uuid.uuid4())

    # ✅ Store session on server
    session_store[session_id] = username

    # ✅ Create response + set cookie
    resp = make_response(redirect("/protected/"))
    resp.set_cookie("session_id", session_id)

    return resp


@app.route("/protected/")
def protected():
    # ✅ Read cookie from request
    session_id = request.cookies.get("session_id")

    if not session_id:
        return redirect("/")

    # ✅ Validate session
    user = session_store.get(session_id)

    if not user:
        return redirect("/")

    return render_template("protectedpage.html", username=user)


@app.route("/logout/")
def logout():
    session_id = request.cookies.get("session_id")

    if session_id in session_store:
        session_store.pop(session_id)

    resp = make_response(redirect("/"))
    resp.set_cookie("session_id", "", expires=0)

    return resp


if __name__ == "__main__":
    app.run(debug=True)