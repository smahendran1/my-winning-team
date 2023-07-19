import java.util.ArrayList;
public class SpottersAffiliate extends SpottersTeam {
        private ArrayList<HockeyPlayer> freeAgentsHockey;
        private ArrayList<BasketballPlayer> freeAgentsBall;
        private ArrayList<HockeyPlayer> teamHockeyA;
        private ArrayList<BasketballPlayer> teamBallA;
        public SpottersAffiliate() throws Exception {
                super();
                freeAgentsHockey = new ArrayList<>();
                freeAgentsBall = new ArrayList<>();
                teamHockeyA = new ArrayList<>();
                teamBallA = new ArrayList<>();
                freeAgentsHockey = getHockeyFreeAgentList();
                freeAgentsBall = getBasketballFreeAgentList();
                teamHockeyA = (ArrayList<HockeyPlayer>) getTeamHockey().clone();
                teamBallA = (ArrayList<BasketballPlayer>) getTeamBall().clone();
        }
        public boolean signPlayer(Object obj, String type) {
                if (type.equalsIgnoreCase("BasketballPlayer")) {
                        BasketballPlayer name = (BasketballPlayer) obj;
                        int index = 0;
                        String position = name.getPosition();
                        if (position.equalsIgnoreCase("center")) {
                                index = 0;
                        } else if (position.equalsIgnoreCase("power forward")) {
                                index = 1;
                        } else if (position.equalsIgnoreCase("small forward")) {
                                index = 2;
                        } else if (position.equalsIgnoreCase("shooting guard")) {
                                index = 3;
                        } else if (position.equalsIgnoreCase("point guard")) {
                                index = 4;
                        }
                        if (name.getName().equalsIgnoreCase(super.getTeamBall().get(index).getName())) {
                                return false;
                        }
                        if (teamBallA.get(index).getName().equals(super.getTeamBall().get(index).getName())) {
                                return true;
                        }
                        if (name.getSalary() < teamBallA.get(index).getSalary() && !name.getName().equalsIgnoreCase(teamBallA.get(index).getName())) {
                                return true;
                        }
                }
                else if (type.equalsIgnoreCase("HockeyPlayer")) {
                        HockeyPlayer name = (HockeyPlayer) obj;
                        int index = 0;
                        String position = name.getPosition();
                        if (position.equalsIgnoreCase("center")) {
                                index = 0;
                        } else if (position.equalsIgnoreCase("left wing")) {
                                index = 1;
                        } else if (position.equalsIgnoreCase("right wing")) {
                                index = 2;
                        } else if (position.equalsIgnoreCase("left defense")) {
                                index = 3;
                        } else if (position.equalsIgnoreCase("right defense")) {
                                index = 4;
                        } else if (position.equalsIgnoreCase("goalie")) {
                                index = 5;
                        }
                      
                        if (name.getName().equalsIgnoreCase(super.getTeamHockey().get(index).getName())) {
                                return false;
                        }
                       
                        if (teamBallA.get(index).getName().equals(super.getTeamHockey().get(index).getName())) {
                                return true;
                        }
                
                        if (name.getSalary() < teamHockeyA.get(index).getSalary() && !name.getName().equalsIgnoreCase(teamHockeyA.get(index).getName())) {
                                return true;
                        }

                }
                return false;
        }
        public int totalSalary(String type) {
                int totSal = 0;
                if (type.equalsIgnoreCase("Hockey")) {
                        for(int i = 0; i < teamHockeyA.size(); i++) {
                                totSal += teamHockeyA.get(i).getSalary();
                        }
                } else {
                        if (type.equalsIgnoreCase("Basketball")) {
                                for (int i = 0; i < teamBallA.size(); i++) {
                                        totSal += teamBallA.get(i).getSalary();
                                }
                        }
                }
                return totSal;
        }
        public void createTeam(String teamType){
                if (teamType.equalsIgnoreCase("HockeyPlayer")) {
                        for (int i = 0; i < freeAgentsHockey.size(); i++) {
                                if (signPlayer((Object) freeAgentsHockey.get(i), "HockeyPlayer")) {//determine whether the type should be hockey or hockeyplayer
                                        String position = freeAgentsHockey.get(i).getPosition();
                                        if (position.equalsIgnoreCase("Center")) {
                                                teamHockeyA.set(0, freeAgentsHockey.get(i));
                                        }
                                        if (position.equalsIgnoreCase("Left Wing")) {
                                                teamHockeyA.set(1, freeAgentsHockey.get(i));
                                        }
                                        if (position.equalsIgnoreCase("Right Wing")) {
                                                teamHockeyA.set(2, freeAgentsHockey.get(i));
                                        }
                                        if (position.equalsIgnoreCase("Left Defense")) {
                                                teamHockeyA.set(3, freeAgentsHockey.get(i));
                                        }
                                        if (position.equalsIgnoreCase("Right Defense")) {
                                                teamHockeyA.set(4, freeAgentsHockey.get(i));
                                        }
                                        if (position.equalsIgnoreCase("Goalie")) {
                                                teamHockeyA.set(5, freeAgentsHockey.get(i));
                                        }
                                }
                        }
                }
                else {
                        for (int i = 0; i < freeAgentsBall.size(); i++) {
                                if (signPlayer((Object) freeAgentsBall.get(i), "BasketballPlayer")) {//determine whether the type should be hockey or hockeyplayer
                                        String position = freeAgentsBall.get(i).getPosition();
                                        if (position.equalsIgnoreCase("Center")) {
                                                teamBallA.set(0, freeAgentsBall.get(i));
                                        }
                                        if (position.equalsIgnoreCase("Power forward")) {
                                                teamBallA.set(1, freeAgentsBall.get(i));
                                        }
                                        if (position.equalsIgnoreCase("Small forward")) {
                                                teamBallA.set(2, freeAgentsBall.get(i));
                                        }
                                        if (position.equalsIgnoreCase("Shooting guard")) {
                                                teamBallA.set(3, freeAgentsBall.get(i));
                                        }
                                        if (position.equalsIgnoreCase("Point guard")) {
                                                teamBallA.set(4, freeAgentsBall.get(i));
                                        }
                                }
                        }
                }
        }
public String toString() {
        if (!teamHockeyA.get(0).getName().equals("fake")){
                return "Center: " + teamHockeyA.get(0).getName() + "\n" +
                        "Left wing: " + teamHockeyA.get(1).getName()+ "\n" +
                        "Right wing: " + teamHockeyA.get(2).getName() +  "\n" +
                        "Left defense: " + teamHockeyA.get(3).getName() + "\n" +
                        "Right defense: " + teamHockeyA.get(4).getName() + "\n" +
                        "Goalie: " + teamHockeyA.get(5).getName() + "\n";
        }
        else {
                return "Center: " + teamBallA.get(0).getName() + "\n" +
                        "Power forward: " + teamBallA.get(1).getName()+ "\n" +
                        "Small forward: " + teamBallA.get(2).getName() +  "\n" +
                        "Shooting guard: " + teamBallA.get(3).getName() + "\n" +
                        "Point guard: " + teamBallA.get(4).getName() + "\n";
        }
        }
}
