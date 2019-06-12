public interface Entrada {
    String getTermo();
    String getDefinicao();
    boolean equals(Object o);
    Entrada clone();
}
