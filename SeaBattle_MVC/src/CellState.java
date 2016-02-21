/**
 * Created by Mikhail on 2/21/2016.
 */
public enum CellState {
    MIS {
        public char getChar() {
            return '*';
        }
    },
    WATER {
        public char getChar() {
            return  '~';
        }
    },
    SHIP {
        public char getChar() {
            return 'O';
        }
    },
    HIT {
        public char getChar() {
            return 'X';
        }
    };

    public abstract char getChar();
}
