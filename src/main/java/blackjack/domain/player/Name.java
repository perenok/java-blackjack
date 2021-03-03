package blackjack.domain.player;

import java.util.Objects;

public class Name {

    private final String name;

    public Name(String name){
        validateName(name);
        name= name.trim();
        this.name = name;
    }

    private void validateName(String name) {
        if(Objects.isNull(name) || name.isEmpty()){
            throw new IllegalArgumentException("이름은 공백일 수 없습니다.");
        }
    }

    public String name(){
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Name name1 = (Name) o;
        return Objects.equals(name, name1.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
