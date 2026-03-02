public class User {
    private String username;
    private String pass;
    private Goal [] goals=new Goal[30];

    private int counter=0;
    public User(String name,String pass){
        this.username=name;
        this.pass=pass;
    }
    public void addgoal(String title){
        goals[counter]=new Goal(title);
        counter++;
    }
    public void viewgoals() {
        if (counter == 0) System.out.print("no goals yet");
        else for (int i = 0; i < counter; ++i) {
            System.out.println(goals[i].gettitle());
        }
    }
         public void markdone( int index){
            if (index < 0 || index >= counter) {System.out.print("INVALID INDEX");}
            else {
                goals[index].markdone();
                System.out.print("marked succesfully");
            }
        }

       public void showprogress(){
                 int done=0;
                 for(int i=0;i<counter;i++) {
                     if (goals[i].showmark()) done++;
                 }
                     System.out.println("progress is" +( done*100.0/counter)  +"%" );
