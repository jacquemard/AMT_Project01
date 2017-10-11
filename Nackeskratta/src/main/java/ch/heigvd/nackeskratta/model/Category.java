package ch.heigvd.nackeskratta.model;

public enum Category
{
   BED("Bed"), CHAIR("Chair"), TABLE("Table"), CABINET("Cabinet"), MEATBALLS("Meatballs");
   
   private final String name;
   
   Category(String name){
      this.name = name;
   }
   
   @Override
   public String toString(){
      return name;
   }
}
