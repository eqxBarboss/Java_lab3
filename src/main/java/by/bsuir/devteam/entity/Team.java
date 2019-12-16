package by.bsuir.devteam.entity;

import by.bsuir.devteam.entity.employee.BusinessAnalyst;
import by.bsuir.devteam.entity.employee.Developer;
import by.bsuir.devteam.entity.employee.TeamLead;
import by.bsuir.devteam.entity.employee.Tester;

import java.util.List;
import java.util.Objects;

public class Team implements java.io.Serializable{

    private TeamLead teamLead;
    private SoftwareProduct softwareProduct;
    private List<Tester> testers;
    private List<Developer> developers;
    private List<BusinessAnalyst> businessAnalysts;
    private int maxId;

    public Team(){

    }

    public Team(List<Tester> testers, List<Developer> developers, List<BusinessAnalyst> businessAnalysts,
                TeamLead teamLead, SoftwareProduct softwareProduct) {
        this.testers = testers;
        this.developers = developers;
        this.businessAnalysts = businessAnalysts;
        this.teamLead = teamLead;
        this.softwareProduct = softwareProduct;
    }

    public TeamLead getTeamLead() {
        return teamLead;
    }

    public void setTeamLead(TeamLead teamLead) {
        this.teamLead = teamLead;
    }

    public SoftwareProduct getSoftwareProduct() {
        return softwareProduct;
    }

    public void setSoftwareProduct(SoftwareProduct softwareProduct) {
        this.softwareProduct = softwareProduct;
    }

    public List<Tester> getTesters() {
        return testers;
    }

    public void setTesters(List<Tester> testers) {
        this.testers = testers;
    }

    public List<Developer> getDevelopers() {
        return developers;
    }

    public void setDevelopers(List<Developer> developers) {
        this.developers = developers;
    }

    public List<BusinessAnalyst> getBusinessAnalysts() {
        return businessAnalysts;
    }

    public void setBusinessAnalysts(List<BusinessAnalyst> businessAnalysts) {
        this.businessAnalysts = businessAnalysts;
    }

    public int getMaxId(){
        return this.maxId;
    }

    public void updateMaxId(){
        int max = 0;

        for (int i = 0; i < developers.size(); i++){
            if (developers.get(i).getId() > max)
                max = developers.get(i).getId();
        }
        for (int i = 0; i < businessAnalysts.size(); i++){
            if (businessAnalysts.get(i).getId() > max)
                max = businessAnalysts.get(i).getId();
        }
        for (int i = 0; i < testers.size(); i++){
            if (testers.get(i).getId() > max)
                max = testers.get(i).getId();
        }

        if (teamLead != null)
            max = teamLead.getId();
        if (softwareProduct != null && softwareProduct.getId() > max)
            max = softwareProduct.getId();

        this.maxId = max;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Team team = (Team) o;
        return Objects.equals(teamLead, team.teamLead) &&
                Objects.equals(softwareProduct, team.softwareProduct) &&
                Objects.equals(testers, team.testers) &&
                Objects.equals(developers, team.developers) &&
                Objects.equals(businessAnalysts, team.businessAnalysts);
    }

    @Override
    public int hashCode() {

        return Objects.hash(teamLead, softwareProduct, testers, developers, businessAnalysts);
    }

    @Override
    public String toString() {
        return "Team{" +
                "teamLead=" + teamLead +
                ", softwareProduct=" + softwareProduct +
                ", testers=" + testers +
                ", developers=" + developers +
                ", businessAnalysts=" + businessAnalysts +
                '}';
    }
}