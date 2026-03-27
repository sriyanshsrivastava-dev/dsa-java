package designpattern.builderpattern;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;


public class UserAccountTest {

    @Test
    void shouldCreateUserAccountSuccessfully() {
        UserAccount user = new UserAccount.Builder(
                "rahul",
                "rahul@gmail.com",
                "123456"
        ).setAge(21)
                .setVerified(true)
                .build();

        assertNotNull(user);
    }


    @Test
    void shouldThrowExceptionForInvalidEmail() {
        assertThrows(IllegalArgumentException.class, () -> {
            new UserAccount.Builder(
                    "rahul",
                    "rahulgmail.com",
                    "123456"
            ).build();
        });
    }


    @Test
    void shouldThrowExceptionForNullEmail() {
        assertThrows(IllegalArgumentException.class, () -> {
            new UserAccount.Builder(
                    "rahul",
                    null,
                    "123456"
            ).build();
        });
    }


    @Test
    void shouldThrowExceptionForWeakPassword() {
        assertThrows(IllegalArgumentException.class, () -> {
            new UserAccount.Builder(
                    "rahul",
                    "rahul@gmail.com",
                    "123"
            ).build();
        });
    }

    @Test
    void shouldThrowExceptionForNullPassword() {
        assertThrows(IllegalArgumentException.class, () -> {
            new UserAccount.Builder(
                    "rahul",
                    "rahul@gmail.com",
                    null
            ).build();
        });
    }


    @Test
    void shouldSupportMethodChaining() {
        UserAccount user = new UserAccount.Builder(
                "rahul",
                "rahul@gmail.com",
                "123456"
        ).setAge(25)
                .setAddress("Delhi")
                .setVerified(true)
                .build();

        assertNotNull(user);
    }


    @Test
    void shouldCreateUserWithoutOptionalFields() {
        UserAccount user = new UserAccount.Builder(
                "rahul",
                "rahul@gmail.com",
                "123456"
        ).build();

        assertNotNull(user);
    }


    @Test
    void shouldTrimInputValues() {
        UserAccount user = new UserAccount.Builder(
                "  rahul  ",
                "  rahul@gmail.com  ",
                "  123456  "
        ).build();

        assertNotNull(user);
    }


}
