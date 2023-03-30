
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import static com.google.common.truth.Truth.assertThat;


public class PercolationTest {
    @Test
    public void testOpen(){
        Percolation p = new Percolation(5);
        Percolation p2 = new Percolation(2);
        p.open(4,2);
        p.open(0,3);
        assertThat(p.isOpen(4,2)).isTrue();
        assertThat(p2.isOpen(0,1)).isFalse();
        assertThat(p.isOpen(0,3)).isTrue();

        p2.open(0,0);
        p2.open(0,1);
        p2.open(1,0);
        p2.open(1,1);
    }
    @Test
    public void testIsFull(){
        Percolation p = new Percolation(6);
        p.open(0,5);
        p.open(1,5);
        p.open(2,5);
        p.open(3,5);
        p.open(4,5);
        p.open(4,4);
        p.open(3,3);
        p.open(2,3);
        p.open(1,3);
        p.open(1,3);
        p.open(1,2);
        p.open(1,1);
        p.open(1,0);
        p.open(2,0);
        p.open(3,0);
        p.open(3,0);
        p.open(4,0);
        p.open(4,1);
        p.open(5,1);
        p.open(4,3);

        assertThat(p.isFull(4,4)).isTrue();

    }
    @ Test
    public void testFile() throws FileNotFoundException {

        Scanner sc = new Scanner(new File("/Users/amisha.gupta/Documents/cs/61b/sp23-s155/hw2/inputFiles/wayne98.txt"));
        int size = sc.nextInt();
        Percolation p = new Percolation(size);
        int count = 1;
        while (sc.hasNextInt()) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            p.open(x, y);
            System.out.println(count + "opened" + x + y);
            System.out.println("percolates is " + p.percolates());
            count +=1 ;
        }
        assertThat(p.percolates()).isTrue();

    }
}
