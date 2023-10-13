public class SecretInterpreter {
        private final Cypher cypher;
        
        public SecretInterpreter(Cypher cypher) {
            this.cypher = cypher;
        }
        
        public String hide(String message) {
            return this.cypher.encode(message);
        }
        
        public String reveal(String message) {
            return this.cypher.decode(message);
        }
}
