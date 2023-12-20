package robosim;

public enum MapObjects {
    AIR {
        @Override
        public MapObject createInstance() {
            return new Air();
        }
    },
    BARRIER {
        @Override
        public MapObject createInstance() {
            return new Barrier();
        }
    },
    ROBOT {
        @Override
        public MapObject createInstance() {
            return new Robot();
        }
    };

    public abstract MapObject createInstance();
}