import static org.junit.jupiter.api.Assertions.*;

class MainTest {
    DiGraph d = new DiGraph();
    @org.junit.jupiter.api.Test
    void add(){
        d.add("Mixco", "Antigua", 50);
        d.add("Mixco", "Xela", 30);
        d.add("Xela", "Antigua", 250);
        assertEquals("Edge From: Mixco to: Antigua cost: 50\n" +
                "Edge From: Mixco to: Xela cost: 30\n" +
                "Edge From: Xela to: Antigua cost: 250\n", d.edgesToString());
  }

    @org.junit.jupiter.api.Test
    void delete(){
        d.add("Mixco", "Antigua", 50);
        d.add("Mixco", "Xela", 30);
        d.add("Xela", "Antigua", 250);
        assertEquals("Se ha eliminado la conexion", d.deleteEdge("Mixco", "Xela"));
        assertEquals("Una o ninguna ingresada ciudad no existe", d.deleteEdge("Antigua", "Xela"));
    }
}