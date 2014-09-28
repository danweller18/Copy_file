#include <stdio.h>
#include <sys/types.h>
#include <sys/stat.h>
#include <fcntl.h>
#include <unistd.h>
int main(int argc, char *agrv[]) {

    //declaring variables
    int source;
    int dest;
    char buffer[BUFSIZ];
    int x;

    //error checking to make sure correct input
    if (argc != 3) {
      printf("ERROR please enter correct input: ./copysystemcalls source_file destination_file");
      return 0;
    }

    //open the source file in read/write mode
    source = open(agrv[1], O_RDWR);
    //error checking to make sure source is a real file
    if (source == -1) {
      printf("ERROR cannot open %s\n", agrv[1]);
      return 0;
    }

    //open/create destination file with permissions
    dest = open(agrv[2], O_WRONLY | O_CREAT | O_EXCL, 0666);

    //while loop to read source into buffer and write to destination
    while((x = read(source, buffer, BUFSIZ)) > 0)
        //write to destination
	if (write(dest, buffer, x) != x) {
	    //error checking if file exists
	    printf("ERROR writing to file %s\n", agrv[2]);
	    return 0;
	}
	//print success statement
	printf("Success! %s has been copied to %s\n", agrv[1], agrv[2]);
	return 0;
}
