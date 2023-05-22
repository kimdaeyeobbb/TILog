let coffee = {
    name : "Americano",
    getName : function() {
        return this.name;
    },
    setName : function(name) {
        this.name = name;
    },
    display : function() {
        console.log(this.name);
    }
};

for(let prop of coffee) {
    console.log(prop);
}