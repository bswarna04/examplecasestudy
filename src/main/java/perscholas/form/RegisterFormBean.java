package perscholas.form;


import lombok.Getter;
import lombok.Setter;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.hibernate.validator.constraints.Length;
import perscholas.validation.EmailUnique;
import perscholas.validation.TwoFieldsAreEqual;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@TwoFieldsAreEqual(fieldOneName = "confirmPassword", fieldTwoName = "password", message = "Password and Confirm Password must be the same.")
public class RegisterFormBean {
   //it is a hidden data value and is only need to distinguish an edit from create
    private Integer id;

    @NotEmpty(message = "Username is required")
    private String username;

    @NotEmpty(message = "Email is required") //makes sure email is not null and not empty
    @Pattern(regexp = "^.+@.+$" , message = "Invalid email format")
   // @EmailUnique(message = "Email must be unique")
    private String email;

    @Length(min=1, max=20, message="First name must be between 1 and 20 characters")
    private String firstName;

    @Min(value=1, message="age should be minimum of 1 ")
    @Max(value=50, message="age should be less than 50 ")
    private Integer age;

    @Length(min=1, max=20, message="Last name must be between 1 and 20 characters")
    private String lastName;

    @NotEmpty(message = "password is required")
    @Length(min=5, max=20, message="Password must be between 8 and 20 characters")
    private String password;

    @NotEmpty(message = "confirmPassword is required")
    private String confirmPassword;

    private List<String> errorMessages = new ArrayList<>();

    @Override
    public String toString() {
        return ReflectionToStringBuilder.toString(this, ToStringStyle.MULTI_LINE_STYLE);
    }


}
