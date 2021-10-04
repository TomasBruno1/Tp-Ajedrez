package australchess.cli;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class Player {
    private String color;
    private String name;
}
