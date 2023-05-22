const calc = {
    firstNumber: 100,
    secondNumber:20,
    print: function() {
        let self = this; // 자기자신에 대한 객체에 접근할 수 있도록 지역변수에 this를 담아서 사용함

        function add() {
            // 함수안에 함수를 정의.
            // 메서드에서 정의되는 this와 다름.
            // 자기자신에 대한 객체에 접근할 수 있도록 지역변수에 this를 담아서 사용함

            console.log(self);

            return self.firstNumber + self.secondNumber;
        }

        console.log(this.firstNumber + "+" + this.secondNumber + "=" + add());
    }
}

calc.print();