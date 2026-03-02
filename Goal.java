public class Goal {
   private String title; // we make it private to protect data "encapsulation"
  private boolean done=false;
   public Goal(String title) {
       this.title = title; // the obj variable
   }
   public String gettitle()

    {
        return title;
    }
   public void markdone(){
       done=true;
    }
public boolean showmark(){
       return done;
    }
}
