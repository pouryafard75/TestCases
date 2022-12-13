class duplicationTest {
    void A(){
        wake();
    }
    void B(){
        sleep();
    }
    void run(){
        A();
        B();
        print("run");
    }
    void exit(){
        A();
        B();
        print("exit");
    }
}