import edu.pattern.shapes.creator.impl.CubeFactoryImpl;
import edu.pattern.shapes.model.Cube;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CubeFactoryImplTest {
    @Test
    public void createWrongCubesFromFile() {
        CubeFactoryImpl cubeFactory = new CubeFactoryImpl();
        List<Cube> cubes = cubeFactory.createCubesFromFile("/wrongCubes.txt");
        assertTrue(cubes.isEmpty());
    }

    @Test
    public void createCubesFromFile() {
        CubeFactoryImpl cubeFactory = new CubeFactoryImpl();
        List<Cube> cubes = cubeFactory.createCubesFromFile("/rightCubes.txt");
        assertEquals(10, cubes.size());
    }

}
