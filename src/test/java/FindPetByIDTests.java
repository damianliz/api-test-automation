import com.petstore.api.config.TestBase;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;



public class FindPetByIDTests extends TestBase {

    private int petId;

    @BeforeClass
    public void setup(){
        // post to create a Pet
        // get petId
    }

    @Test
    public void findPetByIdTest() {
        petService.findPetById(petId)
                .then()
                .statusCode(200);
    }
}
