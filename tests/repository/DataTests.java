package repository;

import model.*;
import model.Character;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import java.io.File;
import java.io.IOException;
import java.util.*;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class DataTests {

    @Test
    public void exportBank() {
        try{
            String path = "bank.json";

            File f = new File (path);
            f.createNewFile();

            Knowledge knowledge = new Knowledge();

            knowledge.export();

            assertTrue(f.exists() && !f.isDirectory());

        }catch (Exception ex){
            ex.printStackTrace();
        }
    }

}
