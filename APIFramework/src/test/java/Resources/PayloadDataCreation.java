package Resources;

import PoJoClasses.AddPetPojo;
import PoJoClasses.Category;
import PoJoClasses.Tag;

import java.util.ArrayList;

public class PayloadDataCreation {

    public AddPetPojo addPetPayloadCreation() {
        AddPetPojo addPetPojo = new AddPetPojo();
        addPetPojo.setId(20);
        Category category = new Category();
        category.setId(30);
        category.setName("catName");
        addPetPojo.setCategory(category);
        addPetPojo.setName("Nayan");

        ArrayList<String> p = new ArrayList<>();
        p.add("photourl1");
        addPetPojo.setPhotoUrls(p);

        Tag tag = new Tag();
        tag.setId(40);
        tag.setName("Tag name");
        ArrayList<Tag> t = new ArrayList<>();
        t.add(tag);
        addPetPojo.setTags(t);
        addPetPojo.setStatus("nkavailable");

        return addPetPojo;
    }


    public AddPetPojo addPetPayloadCreation(String id, String name, String status) {
        AddPetPojo addPetPojo = new AddPetPojo();
        addPetPojo.setId(Integer.parseInt(id));
        Category category = new Category();
        category.setId(30);
        category.setName("catName");
        addPetPojo.setCategory(category);
        addPetPojo.setName(name);

        ArrayList<String> p = new ArrayList<>();
        p.add("photourl1");
        addPetPojo.setPhotoUrls(p);

        Tag tag = new Tag();
        tag.setId(40);
        tag.setName("Tag name");
        ArrayList<Tag> t = new ArrayList<>();
        t.add(tag);
        addPetPojo.setTags(t);
        addPetPojo.setStatus(status);

        return addPetPojo;
    }


}

