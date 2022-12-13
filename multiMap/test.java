class duplicationTest {
    void A(){
        wake();
    }
    void B(){
        sleep();
    }
    void extracted(){
        A();
        B();
    }
    void run(){
        extracted();
        print("run");
    }
    void exit(){
        extracted();
        print("exit");
    }
}