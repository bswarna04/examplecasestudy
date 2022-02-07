package perscholas.dependencyinjectionexample;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class Manager {

    @Autowired
    private Worker1 worker1;
    @Autowired
    private Worker2 worker2;
    @Autowired
    private Worker3 worker3;

    public Manager() {

        System.out.println("Im in manger constuctor");

    }

    @PostConstruct
    public void init() {
        worker1.doWork();
        worker2.doWork();
        worker3.doWork();
    }

}

//        this.worker1=worker1;
//        this.worker2=worker2;
//        this.worker3=worker3;


//    public static void main(String[] args){
//
//        Worker1 w1= new Worker1();
//        Worker2 w2= new Worker2();
//        Worker3 w3= new Worker3();
//
//        Manager m=new Manager(w1,w2,w3);
//    }

