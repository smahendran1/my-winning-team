import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
public class SpottersTeam {
    private ArrayList<HockeyPlayer> teamHockey;
    private ArrayList<HockeyPlayer> freeAgentListHockey;
    private ArrayList<BasketballPlayer> teamBasketball;
    private ArrayList<BasketballPlayer> freeAgentListBall;

    private int totalTeamSalary;
    //HockeyPlayer ArrayList should be called teamHockey
    //BasketballPlayer ArrayList should be called teamBasketball
    //if you do not call it these two names you need to change the code at the bottom of this file

    public SpottersTeam(){
        teamHockey = new ArrayList<>();
        teamBasketball = new ArrayList<>();

        for (int i = 0; i < 6; i++){
            teamHockey.add(new HockeyPlayer("fake", 1, "fake", 2000000));
            teamBasketball.add(new BasketballPlayer("fake", 1, "fake", 2000000));
        }
        try (FileReader in = new FileReader("freeagentshockey.txt");
             BufferedReader reader = new BufferedReader(in)){
            String line;
            HockeyPlayer adder;
            while ( (line = reader.readLine()) != null){
                String[] word = line.split("-");
                int addAge = Integer.parseInt(word[1]);
                int addSalary = Integer.parseInt(word[3]);
                adder = new HockeyPlayer(word[0], addAge, word[2], addSalary);
                freeAgentListHockey.add(adder);
            }
        } catch(FileNotFoundException badFile) {
            System.out.println("Could not find the file");
        } catch (IOException uhOh) {
            System.out.println("Trouble reading from file");
        }
        try (FileReader in = new FileReader("freeagentsball.txt");
             BufferedReader reader = new BufferedReader(in)){
            String line;
            BasketballPlayer adder;
            while ( (line = reader.readLine()) != null){
                String[] word = line.split("-");
                int addAge = Integer.parseInt(word[1]);
                int addSalary = Integer.parseInt(word[3]);
                adder = new BasketballPlayer(word[0], addAge, word[2], addSalary);
                freeAgentListBall.add(adder);
            }
        } catch(FileNotFoundException badFile) {
            System.out.println("Could not find the file");
        } catch (IOException uhOh) {
            System.out.println("Trouble reading from file");
        }
    }
    public ArrayList<HockeyPlayer> getHockeyFreeAgentList(){
        return freeAgentListHockey;
    }
    public ArrayList<BasketballPlayer> getBasketballFreeAgentList(){
        return freeAgentListBall;
    }
    public String displayPlayer(String name){
        for (int i = 0; i < teamHockey.size(); i++){
            if (teamHockey.get(i).getName().equals(name)){
                return teamHockey.get(i).toString();
            }
        }
        for (int i = 0; i < teamBasketball.size(); i++){
            if (teamBasketball.get(i).getName().equals(name)){
                return teamBasketball.get(i).toString();
            }
        }

        return "Change Pls";
        return "No player on team with name " + name;
    }

    public boolean signPlayer(Object player, String type) {
        ArrayList<HockeyPlayer> updatedHPlayers = new ArrayList<>();
        ArrayList<HockeyPlayer> finalizedHPlayers = new ArrayList<>();
        ArrayList<BasketballPlayer> updatedBPlayers = new ArrayList<>();

        if (type.equals("hockey")) {
            HockeyPlayer hockeyPlayer = (HockeyPlayer) player;

            for (int i = 0; i < freeAgentListHockey.size(); i++) {
                if (freeAgentListHockey.get(i).getPosition().equals("Center") && freeAgentListHockey.get(i).getAge() < 30) {
                    updatedHPlayers.add(freeAgentListHockey.get(i));
                }
            }

            int lastCenterHockey = updatedHPlayers.size() - 1;

            for (int i = 0; i < freeAgentListHockey.size(); i++) {
                if (freeAgentListHockey.get(i).getPosition().equals("Left wing") && freeAgentListHockey.get(i).getAge() < 30) {
                    updatedHPlayers.add(freeAgentListHockey.get(i));
                }
            }

            int lastLWHockey = updatedHPlayers.size() - 1;

            for (int i = 0; i < freeAgentListHockey.size(); i++) {
                if (freeAgentListHockey.get(i).getPosition().equals("Right wing") && freeAgentListHockey.get(i).getAge() < 30) {
                    updatedHPlayers.add(freeAgentListHockey.get(i));
                }
            }

            int lastRWHockey = updatedHPlayers.size() - 1;

            for (int i = 0; i < freeAgentListHockey.size(); i++) {
                if (freeAgentListHockey.get(i).getPosition().equals("Left defense") && freeAgentListHockey.get(i).getAge() < 30) {
                    updatedHPlayers.add(freeAgentListHockey.get(i));
                }
            }

            int lastLDHockey = updatedHPlayers.size() - 1;

            for (int i = 0; i < freeAgentListHockey.size(); i++) {
                if (freeAgentListHockey.get(i).getPosition().equals("Right defense") && freeAgentListHockey.get(i).getAge() < 30) {
                    updatedHPlayers.add(freeAgentListHockey.get(i));
                }
            }

            int lastRDHockey = updatedHPlayers.size() - 1;

            for (int i = 0; i < freeAgentListHockey.size(); i++) {
                if (freeAgentListHockey.get(i).getPosition().equals("Goalie") && freeAgentListHockey.get(i).getAge() < 30) {
                    updatedHPlayers.add(freeAgentListHockey.get(i));
                }
            }

            int lastGoalieHockey = updatedHPlayers.size() - 1;

            boolean run = true;

            int averageTotalSal = 0;
            for (int i = 0; i < freeAgentListHockey.size(); i++) {
                averageTotalSal += freeAgentListHockey.get(i).getSalary();
            }

            int differenceCenter = updatedHPlayers.get(0).getSalary() - averageTotalSal;
            int differenceLW = updatedHPlayers.get(lastCenterHockey + 1).getSalary() - averageTotalSal;
            int differenceRW = updatedHPlayers.get(lastLWHockey + 1).getSalary() - averageTotalSal;
            int differenceLD = updatedHPlayers.get(lastRWHockey + 1).getSalary() - averageTotalSal;
            int differenceGoalie = updatedHPlayers.get(lastLDHockey + 1).getSalary() - averageTotalSal;

            int centerIndexToAdd = 0;
            int lwIndexToAdd = 0;
            int rwIndexToAdd = 0;
            int ldIndexToAdd = 0;
            int goalieIndexToAdd = 0;

            while (run) {
                for (int i = 1; i <= lastCenterHockey; i++) {
                    if (updatedHPlayers.get(i).getSalary() - averageTotalSal < differenceCenter) {
                        centerIndexToAdd = i;
                    }
                }

                for (int j = lastCenterHockey + 2; j <= lastLWHockey; j++) {
                    if (updatedHPlayers.get(j).getSalary() - averageTotalSal < differenceLW) {
                        lwIndexToAdd = j;
                    }
                }

                for (int k = lastLWHockey + 2; k <= lastRWHockey; k++) {
                    if (updatedHPlayers.get(k).getSalary() - averageTotalSal < differenceRW) {
                        rwIndexToAdd = k;
                    }
                }

                for (int m = lastRWHockey + 2; m <= lastLDHockey; m++) {
                    if (updatedHPlayers.get(m).getSalary() - averageTotalSal < differenceLD) {
                        ldIndexToAdd = m;
                    }
                }

                for (int n = lastLDHockey + 2; n <= lastGoalieHockey; n++) {
                    if (updatedHPlayers.get(n).getSalary() - averageTotalSal < differenceGoalie) {
                        goalieIndexToAdd = n;
                    }
                }

                finalizedHPlayers.add(updatedHPlayers.get(centerIndexToAdd));
                finalizedHPlayers.add(updatedHPlayers.get(lwIndexToAdd));
                finalizedHPlayers.add(updatedHPlayers.get(rwIndexToAdd));
                finalizedHPlayers.add(updatedHPlayers.get(ldIndexToAdd));
                finalizedHPlayers.add(updatedHPlayers.get(goalieIndexToAdd));

                if (finalizedHPlayers.contains(hockeyPlayer)) {
                    return true;
                } else {
                    return false;
                }
            }
        }

        return false; // Return false if type is not "hockey"
    }



    public String toString(){
        String x="";

        for(int i=0; i<addedTeamH.size();i++){
            x= x.concat( "" + addedTeamH.get(i).getPosition() + ": " + addedTeamH.get(i).getName()) + "\n";
        }
        for(int i=0; i<addedTeamB.size();i++){
            x= x.concat( "" + addedTeamB.get(i).getPosition() + ": " + addedTeamB.get(i).getName()) + "\n";
       }

        return x;
      
    }

    public int totalSalaryHockey (){
        int salary = 0;

        for (int i = 0; i < teamHockey.size(); i++){
            salary += teamHockey.get(i).getSalary();
        }
        return salary;
    }

    public HockeyPlayer highestSalaryHockey(){
        int highestSalary = 0;
        int index = 0;

        for (int i = 0; i < teamHockey.size(); i++){
            if (teamHockey.get(i).getSalary() > highestSalary) {
                highestSalary = teamHockey.get(i).getSalary();
                index = i;
            }
        }

        return teamHockey.get(index);
    }

    public HockeyPlayer lowestSalaryHockey(){
        int lowestSalary = 0;
        int index = 0;

        for (int i = 0; i < teamHockey.size(); i++){
            if (teamHockey.get(i).getSalary() < lowestSalary) {
                lowestSalary = teamHockey.get(i).getSalary();
                index = i;
            }
        }

        return teamHockey.get(index);
    }

    public int averageSalaryHockey(){
        return totalSalaryHockey()/teamHockey.size();
    }

    public int totalSalaryBall(){
        int salary = 0;

        for (int i = 0; i < teamBasketball.size(); i++){
            salary += teamBasketball.get(i).getSalary();
        }
        return salary;
    }

    public BasketballPlayer highestSalaryBall(){
        int highestSalary = 0;
        int index = 0;

        for (int i = 0; i < teamBasketball.size(); i++){
            if (teamBasketball.get(i).getSalary() > highestSalary) {
                highestSalary = teamBasketball.get(i).getSalary();
                index = i;
            }
        }

        return teamBasketball.get(index);
    }

    public BasketballPlayer lowestSalaryBall(){
        int lowestSalary = 0;
        int index = 0;

        for (int i = 0; i < teamBasketball.size(); i++){
            if (teamBasketball.get(i).getSalary() < lowestSalary) {
                lowestSalary = teamBasketball.get(i).getSalary();
                index = i;
            }
        }

        return teamBasketball.get(index);
    }

    public int averageSalaryBall(){
        return totalSalaryBall()/teamBasketball.size();
    }

    public ArrayList<HockeyPlayer> getFreeAgentListHockey(){
        return freeAgentListHockey;
    }

    public ArrayList<BasketballPlayer> getFreeAgentListBasketBall(){
        return freeAgentListBall;
    }

    //==============================
    //Methods used for unit testing
    //only do not change
    //setTeam should NOT be used anywhere else
    //getTeam should be used in the SpottersAffiliate class
    public void setTeamHockey (ArrayList<HockeyPlayer> teamList) {
        teamHockey = teamList;
    }
    public ArrayList<HockeyPlayer> getTeamHockey () {
        return teamHockey;
    }
    public void setTeamBall (ArrayList<BasketballPlayer> teamList) {
        teamBasketball = teamList;
    }
    public ArrayList<BasketballPlayer> getTeamBall () {
        return teamBasketball;
    }
    //==============================
}
