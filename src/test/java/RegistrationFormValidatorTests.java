import com.academy.fx.controller.AdminController;
import com.academy.fx.controller.RegistrationController;
import com.academy.fx.model.RegistrationForm;
import com.academy.fx.model.RegistrationFormFiller;
import com.academy.fx.validator.RegistrationValidator;
import org.testng.annotations.Test;
import org.testng.Assert;

public class RegistrationFormValidatorTests {
    String firstName = "FirstName";
    String lastName = "LastName";
    String email = "test@test.ru";
    String password = "Password1";
    String confirmPassword = "Password1";
    AdminController aC = new AdminController();
    RegistrationFormFiller rF = new RegistrationFormFiller();
    RegistrationController rC = new RegistrationController();
    RegistrationValidator validator = new RegistrationValidator();


    @Test
    public void testFirstNameValidation() {
        aC.onClickRegisterLink();
        RegistrationForm newRF = rF.fillFormEmptyFirstName("", lastName, email, password, confirmPassword);
        rC.onClickRegisterButton();
        boolean isValid = validator.validate(newRF);
        String msgError = validator.getMsgError();
        Assert.assertEquals(msgError, "Empty field 'First Name'");
    }

    @Test
    public void testLastNameValidation() {
        aC.onClickRegisterLink();
        RegistrationForm newRF = rF.fillFormEmptyFirstName(firstName, "", email, password, confirmPassword);
        rC.onClickRegisterButton();
        boolean isValid = validator.validate(newRF);
        String msgError = validator.getMsgError();
        Assert.assertEquals(msgError, "Empty field 'Last Name'");
    }

    @Test
    public void testEmailValidation() {
        aC.onClickRegisterLink();
        RegistrationForm newRF = rF.fillFormEmptyFirstName(firstName, lastName, "", password, confirmPassword);
        rC.onClickRegisterButton();
        boolean isValid = validator.validate(newRF);
        String msgError = validator.getMsgError();
        Assert.assertEquals(msgError, "Empty field 'E-mail'");
    }

    @Test
    public void testEmailFormatValidation() {
        aC.onClickRegisterLink();
        RegistrationForm newRF = rF.fillFormEmptyFirstName(firstName, lastName, "my-mail.ru", password, confirmPassword);
        rC.onClickRegisterButton();
        boolean isValid = validator.validate(newRF);
        String msgError = validator.getMsgError();
        Assert.assertEquals(msgError, "Not correct format of email 'my-mail.ru'");
    }

    @Test
    public void testPasswordValidation() {
        aC.onClickRegisterLink();
        RegistrationForm newRF = rF.fillFormEmptyFirstName(firstName, lastName, email, "", confirmPassword);
        rC.onClickRegisterButton();
        boolean isValid = validator.validate(newRF);
        String msgError = validator.getMsgError();
        Assert.assertEquals(msgError, "Empty field password");
    }

    @Test
    public void testPasswordDigitValidation() {
        aC.onClickRegisterLink();
        RegistrationForm newRF = rF.fillFormEmptyFirstName(firstName, lastName, email, "password", confirmPassword);
        rC.onClickRegisterButton();
        boolean isValid = validator.validate(newRF);
        String msgError = validator.getMsgError();
        Assert.assertEquals(msgError, "Password must conatin digit");
    }

    @Test
    public void testPasswordUpperCaseValidation() {
        aC.onClickRegisterLink();
        RegistrationForm newRF = rF.fillFormEmptyFirstName(firstName, lastName, email, "password1", confirmPassword);
        rC.onClickRegisterButton();
        boolean isValid = validator.validate(newRF);
        String msgError = validator.getMsgError();
        Assert.assertEquals(msgError, "Password must conatin upper symbols");
    }

    @Test
    public void testPasswordLowerCaseValidation() {
        aC.onClickRegisterLink();
        RegistrationForm newRF = rF.fillFormEmptyFirstName(firstName, lastName, email, "PASSWORD1", confirmPassword);
        rC.onClickRegisterButton();
        boolean isValid = validator.validate(newRF);
        String msgError = validator.getMsgError();
        Assert.assertEquals(msgError, "Password must conatin lower symbols");
    }

    @Test
    public void testConfirmaPassValidation() {
        aC.onClickRegisterLink();
        RegistrationForm newRF = rF.fillFormEmptyFirstName(firstName, lastName, email, password, "Password2");
        rC.onClickRegisterButton();
        boolean isValid = validator.validate(newRF);
        String msgError = validator.getMsgError();
        Assert.assertEquals(msgError, "Not equals passwords");
    }

    @Test
    public void testExistensUserValidation() {
        aC.onClickRegisterLink();
        RegistrationForm newRF = rF.fillFormEmptyFirstName(firstName, lastName, "test@mail.ru", password, confirmPassword);
        rC.onClickRegisterButton();
        boolean isValid = validator.validate(newRF);
        String msgError = validator.getMsgError();
        Assert.assertEquals(msgError, "User with email 'test@mail.ru' already exists");
    }


}
