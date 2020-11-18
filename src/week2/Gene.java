package week2;

public class Gene implements Comparable{
    private String chromosome;
    private String locus;


    public Gene(String chromo, String loc) {
        this.chromosome = chromo;
        this.locus = loc;
    }

    public String getChromosome() {
        return chromosome;
    }

    public void setChromosome(String chromosome) {
        this.chromosome = chromosome;
    }

    public String getLocus() {
        return locus;
    }

    public void setLocus(String locus) {
        this.locus = locus;
    }

    @Override
    public int compareTo(Object o) {
        Gene g  = (Gene) o;
        try {
            int objectChromosome = Integer.parseInt(g.getChromosome());
            int chromosome = Integer.parseInt(this.getChromosome());
            if (objectChromosome < chromosome) {
                return 1;
            } else if (objectChromosome > chromosome) {
                return -1;
            } else {
                return 0;
            }
        } catch (Exception e) {
            char oC = g.getChromosome().charAt(0);
            char c = this.getChromosome().charAt(0);
            if (oC < c) {
                return 1;
            } else if (oC > c) {
                return -1;
            } else {
                return 0;
            }
        }
    }
}
