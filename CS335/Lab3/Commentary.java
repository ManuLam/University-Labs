//Commentary.java
import java.util.ArrayList;
import java.util.List;

public interface Commentary {

	public void setDesc(String desc);
}
//CommentaryObject.java                                                                               000664  001750  001750  00000001647 13244037035 015511  0                                                                                                    ustar 00haowu                           haowu                           000000  000000

class CommentaryObject implements Commercial,Subject,Commentary{

	private final List<Observer>observers;
	private String desc;
	private final String subjectDetails;
	private String commercialTitle;

	public CommentaryObject(List<Observer>observers, String title, String subjectDetails){
		this(observers, subjectDetails);
		this.commercialTitle = title;


	}

	public CommentaryObject(List<Observer>observers,String subjectDetails){
		this.observers = observers;
		this.subjectDetails = subjectDetails;
	}

	@Override
	public void subscribeObserver(Observer observer) {
		observers.add(observer);
	}

	@Override
	public void unSubscribeObserver(Observer observer) {
		int index = observers.indexOf(observer);
		observers.remove(index);
	}

	public void notifyObservers(String title) {
		System.out.println();
		for(Observer observer : observers){
			observer.update(title);
		}
	}

	public void setCommercial(String title) {
		this.commercialTitle = title;
		notifyObservers(this.commercialTitle);
	}

	@Override
	public void setDesc(String title) {
		this.desc = title;
		notifyObservers(this.desc);
	}

	@Override
	public String subjectDetails() {
		return subjectDetails;
	}
}


//Observer.java

interface Observer {

	public void update(String commercialTitle);
	public void subscribe();
	public void unSubscribe();
}
//SMSUsers.java                                                                                       000664  001750  001750  00000001720 13244037047 013723  0                                                                                                    ustar 00haowu                           haowu                           000000  000000

class SMSUsers implements Observer{

	private final Subject subject;
	private String desc;
	private String userInfo;

	public SMSUsers(Subject subject,String userInfo){
		if(subject==null){
			throw new IllegalArgumentException("No Publisher found.");
		}
		this.subject = subject;
		this.userInfo = userInfo;
	}

	@Override
	public void update(String desc) {
		this.desc = desc;
		display();
	}


	private void display(){
		System.out.println("["+userInfo+"]: "+desc);
	}

	@Override
	public void subscribe() {
		System.out.println("Subscribing "+userInfo+" to "+subject.subjectDetails()+" ...");
		this.subject.subscribeObserver(this);
		System.out.println("Subscribed successfully.");
	}

	@Override
	public void unSubscribe() {
		System.out.println("Unsubscribing "+userInfo+" to "+subject.subjectDetails()+" ...");
		this.subject.unSubscribeObserver(this);
		System.out.println("Unsubscribed successfully.");
	}

}


interface Commercial {
	public void setCommercial(String title);
}

//Subject.java

interface Subject {

	public void subscribeObserver(Observer observer);
	public void unSubscribeObserver(Observer observer);
	public void notifyObservers(String title);
	public String subjectDetails();
}


//                                                                                                                                                                                                               TestObserver.java                                                                                   000664  001750  001750  00000001755 13244037057 014677  0

class TestObserver {

	public static void main(String[] args) {
		Subject subject = new CommentaryObject(new ArrayList<Observer>(), "Soccer Match [2014AUG24]");

		Observer observer = new SMSUsers(subject, "Adam Warner [New York]");
		observer.subscribe();

		System.out.println();

		Observer observer2 = new SMSUsers(subject, "Tim Ronney [London]");
		observer2.subscribe();

		Commentary cObject = ((Commentary)subject);
		cObject.setDesc("Welcome to live Soccer match");
		cObject.setDesc("Current score 0-0");

		System.out.println();

		observer2.unSubscribe();

		System.out.println();

		cObject.setDesc("It's a goal!!");
		cObject.setDesc("Current score 1-0");

		System.out.println();

		Observer observer3 = new SMSUsers(subject, "Marrie [Paris]");
		observer3.subscribe();

		System.out.println();

		cObject.setDesc("It's another goal!!");
		cObject.setDesc("Half-time score 2-0");

		Commercial commercial = ((Commercial)subject);

		commercial.setCommercial("half time####");

	}

}