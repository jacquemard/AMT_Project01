package ch.heigvd.nackeskratta.model;

public enum Material
{
   WOOD("Wood"), METAL("Metal"), PLASTIC("Plastic"), HORSE("Horse");
   
   private final String name;
   
   Material(String name){
      this.name = name;
   }
   
   @Override
   public String toString(){
      return name;
   }
}
