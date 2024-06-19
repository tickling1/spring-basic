package hello.core.singleton;

public class SingletonService {
    
    // 클래스 레벨(스태틱 영역)
    private static final SingletonService instance = new SingletonService();

    public static SingletonService getInstance() {
        return instance;
    }


    // public이면 외부에서 여전히 new 키워드를 사용하여 새로운 인스턴스를 생성할 수 있다.
    // 생성자를 private으로 선언하여 외부에서 인스턴스를 생성하지 못하게 함.
    private SingletonService() {
        
    }
    
    public void logic () {
        System.out.println("싱글톤 객체 로직 호출");
    }
}
