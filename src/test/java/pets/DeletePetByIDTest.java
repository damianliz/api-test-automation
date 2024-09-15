package pets;

import com.petstore.api.models.pet.PetCategory;
import com.petstore.api.models.pet.PetRequestBody;
import com.petstore.api.models.pet.PetTags;
import com.petstore.api.services.PetService;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.Random;

import static org.hamcrest.Matchers.is;


public class DeletePetByIDTest {

    private int petId;
    private String petName;
    private PetService petService;

    @BeforeClass
    public void setup() {
        petService = new PetService();
        petId = new Random().nextInt(100);
        petName = "pet name-" + petId;

        PetCategory category = PetCategory
                .builder()
                .id(1)
                .name("Dogs")
                .build();

        PetTags tags = PetTags
                .builder()
                .id(1)
                .name("small")
                .build();

        PetRequestBody requestBody = PetRequestBody
                .builder()
                .id(petId)
                .name(petName)
                .category(category)
                .photoUrls(Arrays.asList("http://photo-url-1", "http://photo-url-2"))
                .tags(Collections.singletonList(tags))
                .status("available")
                .build();

        petService.addNewPet(requestBody)
                .then()
                .statusCode(200)
                .body("id", is(petId))
                .body("name", is(petName))
                .body("status", is("available"));
    }

    @Test
    public void deletePet() {
        petService.deletePet(petId)
                .then()
                .statusCode(200);
    }
}
