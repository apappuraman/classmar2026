from myprog import myfunc3

def myFunc1():
    print("I am in my func1....")

def myfunc2():
    print("I am in myfunc2...")

def myfunc4():
    return (2,3)

if __name__ == "__main__":
    #myFunc1()
    #myfunc3()
    l=(1,2,3)
    print(l)
    a,b,c=l
    print("a=", a)
    print("b=", b)
    print("c=",c)

    x,y=myfunc4()
    print("x=", x, "y=", y)