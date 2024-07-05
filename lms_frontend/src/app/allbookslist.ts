export class Allbookslist {
    public bookid?:number;

    constructor(
        public bookname:string,
        public availability: string,
        public booktopic:string,
        public price:number,
        public description:string,
        public edition: string, 
    ){}

    // constructor(){
    //     this.availability = "Yes";
    //     this.description = " ";
    // }

}

