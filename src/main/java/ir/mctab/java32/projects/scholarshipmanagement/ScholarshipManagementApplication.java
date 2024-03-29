package ir.mctab.java32.projects.scholarshipmanagement;

import ir.mctab.java32.projects.scholarshipmanagement.features.scholarshipverification.impl.*;
import ir.mctab.java32.projects.scholarshipmanagement.features.scholarshipverification.usecases.*;
import ir.mctab.java32.projects.scholarshipmanagement.features.usermanagement.impl.LoginUseCaseImpl;
import ir.mctab.java32.projects.scholarshipmanagement.features.usermanagement.impl.LogoutUseCaseImpl;
import ir.mctab.java32.projects.scholarshipmanagement.features.usermanagement.usecases.LoginUseCase;
import ir.mctab.java32.projects.scholarshipmanagement.features.usermanagement.usecases.LogoutUseCase;
import ir.mctab.java32.projects.scholarshipmanagement.model.Scholarship;
import ir.mctab.java32.projects.scholarshipmanagement.model.User;

import java.util.List;
import java.util.Scanner;

public class ScholarshipManagementApplication {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String command = "";
        while (! command.equals("exit")) {
            System.out.println("exit,login,suplist,manlist,supaccept,manaccept,supreject,manreject,stulist,request,unilist,logout");
            System.out.println("what do you want? ");
            command = scanner.nextLine();
            // Login
            if (command.equals("login")) {
                System.out.println("Username : ");
                String username = scanner.nextLine();
                System.out.println("Password : ");
                String password = scanner.nextLine();
                LoginUseCase loginUseCase = new LoginUseCaseImpl();
                User user = loginUseCase.login(username, password);
                if (user != null) {
                    System.out.println(" Login successful by " + user.getRole());
                }
            }
            // find scholarship by supervisor
            if (command.equals("suplist")) {
                FindScholarshipBySupervisorUseCase findScholarshipBySupervisorUseCase
                        = new FindScholarshipBySupervisorUseCaseImpl();

                List<Scholarship> scholarships = findScholarshipBySupervisorUseCase
                        .listScholarships();
                for (int i = 0; i < scholarships.size(); i++) {
                    System.out.println(scholarships.get(i));
                }
            }
            // findScholarshipByManager
            if (command.equals("manlist")) {
                FindScholarshipByManagerUseCase findScholarshipByManagerUseCase = new FindScholarshipByManagerUseCaseImpl();

                List<Scholarship> scholarships = findScholarshipByManagerUseCase.listScholarships();
                for (int i = 0; i < scholarships.size(); i++) {
                    System.out.println(scholarships.get(i));
                }
            }

            // acceptBySupervisor
            if (command.equals("supaccept")) {
                AcceptScholarshipBySupervisorUseCase acceptScholarshipBySupervisorUseCase
                        = new AcceptScholarshipBySupervisorUseCaseImpl();
                System.out.println("Scholarship Id: ");
                String scholarshipId = scanner.nextLine();
                acceptScholarshipBySupervisorUseCase.accept(Long.parseLong(scholarshipId));
                System.out.println("Done.");
            }
            // acceptByManager
            if (command.equals("manaccept")) {
                AcceptScholarshipByManagerUseCase acceptScholarshipByManagerUseCase
                        = new AcceptScholarshipByManagerUseCaseImpl();
                System.out.println("Scholarship Id: ");
                String scholarshipId = scanner.nextLine();
                acceptScholarshipByManagerUseCase.accept(Long.parseLong(scholarshipId));
                System.out.println("Done.");
            }
            // rejectBySupervisor
            if (command.equals("supreject")) {
                RejectScholarshipBySupervisorUseCase rejectScholarshipBySupervisorUseCase
                        = new RejectScholarshipBySupervisorUseCaseImpl();
                System.out.println("Scholarship Id: ");
                String scholarshipId = scanner.nextLine();
                rejectScholarshipBySupervisorUseCase.reject(Long.parseLong(scholarshipId));
                System.out.println("Done.");
            }

            // rejectByManager

            if (command.equals("manreject")) {
                RejectScholarshipByManagerUseCase rejectScholarshipByManagerUseCase
                        =new RejectScholarshipByManagerUseCaseImpl();

                System.out.println("Scholarship Id: ");
                String scholarshipId = scanner.nextLine();
                rejectScholarshipByManagerUseCase.reject(Long.parseLong(scholarshipId));
                System.out.println("Done.");
            }

            // findScholarshipByManager

            if (command.equals("stulist")) {
                FindScholarshipByStudentUseCase findScholarshipByStudentUseCase = new FindScholarshipByStudentUseCaseImpl();
                System.out.println("Scholarship Id: ");
                String scholarshipId = scanner.nextLine();
                Scholarship scholarship = findScholarshipByStudentUseCase.find(Long.parseLong(scholarshipId));
                System.out.println(scholarship.toString());
            }
            //requestByStudent
            if (command.equals("request")) {
                RequestScholarshipByStudentUseCase requestScholarshipByStudentUseCase
                        = new RequestScholarshipByStudentUseCaseImpl();

                boolean x = requestScholarshipByStudentUseCase.request();
                if(x){
                    System.out.println("Done.");
                }
            }

            //findScholarshipByUniversity
            if(command.equals("unilist")){
                FindScholarshipByUniversityUseCase findScholarshipByUniversityUseCase
                        = new FindScholarshipByUniversityUseCaseImpl();
                List<Scholarship> scholarships = findScholarshipByUniversityUseCase.listScholarships();
                for (int i = 0; i < scholarships.size(); i++) {
                    System.out.println(scholarships.get(i));
                }
            }
            //DashboardByManager
            if (command.equals("mandash")) {
                DashboardByManagerUseCase dashboardByManagerUseCase
                        = new DashboardByManagerUseCaseImpl();
                dashboardByManagerUseCase.dashboard();

            }
            //DashboardBySupervisor
            if (command.equals("supdash")) {
                DashboardBySupervisorUseCase dashboardBySupervisorUseCase
                        = new DashboardBySupervisorUseCaseImpl();
                dashboardBySupervisorUseCase.dashboard();

            }

            //log out
            if (command.equals("logout")) {
                LogoutUseCase logoutUseCase = new LogoutUseCaseImpl();
                logoutUseCase.logout();
            }


        }

    }
}

