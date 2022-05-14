import java.util.Optional;

public class CircularListTestUtils {
    public static boolean checkOptionalInteger(Optional<Integer> optional, int value){
        return optional.isPresent() && value == optional.get();
    }
}
