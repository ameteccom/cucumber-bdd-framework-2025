package stepdefinitions;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;

import java.util.List;
import java.util.Map;

public class CreateFacebookAccount_Database_StepDef {

    @Given("I open Facebook URL and Create account with below information")
    public void i_open_facebook_url_and_create_account_with_below_information(DataTable dataTable) {
        List<Map<String, String>> fbUsers = dataTable.asMaps();

        System.out.println((fbUsers));
        for(Map<String, String> user: fbUsers){
            System.out.println("First Name ---> " + user.get("First Name"));
            System.out.println("Last Name ---> " + user.get("Last Name"));
            System.out.println("Email Address ---> " + user.get("Email Address"));
            System.out.println("Phone Number ---> " + user.get("Phone Number"));
            System.out.println("Date of Birth ---> " + user.get("DOB"));
            System.out.println("----------------------------------------------");

        }
    }
}
