public class Vertex {
    private final int id;

    public Vertex(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return String.valueOf(id);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Vertex)) return false;
        Vertex vertex = (Vertex) o;
        return id == vertex.id;
    }

    @Override
    public int hashCode() {
        return id;
    }
}