import socket
from mybizlogic import getUserInfo, getEmployeeInfo
HOST = '127.0.0.1'   # Listen on all interfaces
PORT = 5000        # Port number

def start_server():
    # Create socket
    server_socket = socket.socket(socket.AF_INET, socket.SOCK_STREAM)
    
    # Reuse address (avoids "address already in use" error)
    server_socket.setsockopt(socket.SOL_SOCKET, socket.SO_REUSEADDR, 1)
    
    # Bind to host and port
    server_socket.bind((HOST, PORT))
    
    # Start listening
    server_socket.listen(5)
    print(f"Server listening on {HOST}:{PORT}...")

    while True:
        # Accept client connection
        client_socket, addr = server_socket.accept()
        print(f"Connection from {addr}")

        # Receive data
        data = client_socket.recv(1024)
        print("Received request:")
        print(data.decode())

        # Send response
        response = "Hello from server!"
        client_socket.send(response.encode())

        # Close connection
        client_socket.close()


    #URL -> Uniform resource locator
    #127.0.0.1:5000/userinfo
    #127.0.0.1:5000/employeeinfo
    '''
        if(parseResoruceName(data)==  "userinfo")
            return getUserInfo(parseParameter("id", data))
        
        if(parseResoruceName(data)==  "employeeinfo")
            return getEmployeeInfo(parseParameter("id", data))
    ''' 
if __name__ == "__main__":
    start_server()