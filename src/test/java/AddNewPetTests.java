import com.petstore.api.config.TestBase;
import com.petstore.api.models.pet.PetCategory;
import com.petstore.api.models.pet.PetRequestBody;
import com.petstore.api.models.pet.PetTags;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;
import org.testng.collections.Lists;

import java.util.Arrays;
import java.util.Collections;
import java.util.Random;

import static org.hamcrest.Matchers.is;

public class AddNewPetTests extends TestBase {

    @Test
    public void addNewPetTest_status_available_cat_1() {
        int petId = new Random().nextInt(100);
        String petName = "pet name-" + petId;

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
}
