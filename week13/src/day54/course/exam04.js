const calc = {
    firstNumber: 100,
    secondNumber:20,
    print: function() {
        const add = () => {
            console.log(this);   // 화살표함수를 사용하면 this를 쓰면 객체 자기 자신을 참조하게 됨 (calc객체 자기자신을 가리킴)
            // 일반함수로 만들경우 window객체를 참조하게 됨
            return this.firstNumber + this.secondNumber;
        }

        console.log(this.firstNumber + "+" + this.secondNumber + "=" + add());
    }
}

calc.print();