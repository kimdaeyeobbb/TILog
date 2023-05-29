import { defineStore } from "pinia";
import axios from 'axios';

export const useWeatherStore = defineStore({
    id: 'WeatherStore',
    state: () =>
    {
        return {time: "zz"}
    },
    actions:{
        async getWeatherInfo() {
            try{
                const response = await axios.get('http://localhost:8088/weather');
                console.log("axios로 넘어오는 값: "+response)
                console.log("response.data.time: "+ response.data.time)
                this.time = response.data.time;
                console.log("this.time: " + this.time)
                console.log("타임: "+ this.time)
            } catch (error){
                console.log("에러 발생; "+ error)
            }

        }
    },
})