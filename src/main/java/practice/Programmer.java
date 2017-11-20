package practice;

import java.util.Collection;
import java.util.HashSet;

class Programmer {

    protected Collection<String> languages;

    public Programmer() {
        this.languages = new HashSet<>();
    }

    public Collection<String> getLanguages() {
        return languages;
    }

    public void addLanguage(String newLanguage) {
        languages.add(newLanguage);
    }

}

class ProgrammerTeacher extends Programmer {

    public boolean teach(Programmer programmer, String language) {
        if (this.languages.contains(language)){
            programmer.languages.add(language);
            return true;
        }
        return false;
    }


    public static void main(String[] args) {

      ProgrammerTeacher teacher = new ProgrammerTeacher();
      teacher.addLanguage("Java");

      Programmer programmer = new Programmer();
      teacher.teach(programmer, "Java");

      for(String language : programmer.getLanguages())
          System.out.println(language);
    }
}