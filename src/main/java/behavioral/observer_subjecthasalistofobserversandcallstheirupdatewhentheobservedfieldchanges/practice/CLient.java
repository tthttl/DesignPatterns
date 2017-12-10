package behavioral.observer.practice;

public class CLient {

    public static void main(String[] args) {

        Observer observer = new ObserverImp();
        SubjectImp subject = new SubjectImp();
        subject.addObserver(observer);

        subject.setApple(1);
        subject.setGoogle(2);



    }

}
