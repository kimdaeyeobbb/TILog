const calc = {
    firstNumber: 100,
    secondNumber:20,
    print: function() {
        console.log(this);
        // 객체 자기자신을 가리킴
        // {firstNumber: 100, secondNumber: 20, print: ƒ}


        // 객체의 메서드 내에서 또 사용가능한 메서드를 만들면 내부의 메서드에서는 this를 쓸 때 자기자신을 참조하는 용도로 사용하면 안됨.
        // 이러한 경우 해당 함수를 호출할 때 전달을 해서 처리해야 함.

        function add() {
            console.log(this);
            // window 객체를 가리킴
            // Window {window: Window, self: Window, document: document, name: '', location: Location, …}

            return this.firstNumber + this.secondNumber;
        }

        console.log(this.firstNumber + "+" + this.secondNumber + "=" + add());
        // 100+20=NaN
        // add() -> 객체 자기자신이 아닌 window객체를 참조하므로 없는 속성을 가지고 연산을 하려고하고 NaN가 나오게 됨
        // 이를 해결하려면 exam03처럼해야함
    }
}

calc.print();