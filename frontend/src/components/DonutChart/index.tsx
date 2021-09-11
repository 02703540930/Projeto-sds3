import axios from 'axios';
import { useEffect, useState } from 'react';
import Chart from 'react-apexcharts'
import { SaleSum } from 'types/Sale';
import { BASE_URL } from 'utils/request';

type ChartData = {
    labels: string[];
    series: number[];
}

const DonutChart = () => {
    // componente que vai receber os dados com o useState
    const [chartData, setChartData] = useState<ChartData>({ labels: [], series: [] });
    
    useEffect(() => {
        //requisicao para buscar soma das vendas dos vendedores
        axios.get(`${BASE_URL}/sales/amount-by-seller`)
            .then(response => {
                const data = response.data as SaleSum[];                  //cria uma constante com os dados de SaleSum
                const myLabels = data.map(x => x.sellerName);              //traz para myLabels cada xsellerName do datamap do SaleSum
                const mySeries = data.map(x => x.sum);                     //traz para mySeries cada xsum do data.map do SaleSum 

                setChartData({ labels: myLabels, series: mySeries });       //charData recebe os myLabels e mySeries criados no map acima
                //console.log(chartData);                                   //busca a resposta escrita no charData usado para inspecionar no navegador manter como comentario
            });

    }, []);

    //const mockData = {
    //   series: [477138, 499928, 444867, 220426, 473088],
    //  labels: ['Anakin', 'Barry Allen', 'Kal-El', 'Logan', 'Padmé']
    //}

    const options = {
        legend: {
            show: true
        }
    }

    return (
        <Chart
            options={{ ...options, labels: chartData.labels }}
            series={chartData.series}
            type="donut"
            height="240"
        />
    );
}

export default DonutChart;