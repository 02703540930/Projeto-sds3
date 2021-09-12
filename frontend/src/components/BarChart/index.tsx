import axios from 'axios'
import { useEffect, useState } from 'react'
import Chart from 'react-apexcharts'
import { SaleSuccess } from "types/sale";
import { round } from 'utils/format'
import { BASE_URL } from 'utils/request'

type SeriesData = {
    name: string;
    data: number[];
}
type ChartData = {
    labels: {
        categories: string[];
    };
    series: SeriesData[];

}

const BarChart = () => {

    const [chartData, setChartData] = useState<ChartData>({
        labels: {
            categories: []
        },
        series: [
            {
                name: "",
                data: []
            }
        ]
    });

    useEffect(() => {
        //requisicao para buscar o percentual de sucesso das vendas dos vendedores
        axios.get(`${BASE_URL}/sales/success-by-seller`)
            .then(response => {
                const data = response.data as SaleSuccess[];                              //cria uma constante com os dados de SaleSuccess
                const myLabels = data.map(x => x.sellerName);                             //traz para myLabels cada xsellerName do datamap do SaleSuccess
                const mySeries = data.map(x => round(100.0 * x.deals / x.visited, 1));    //traz para mySeries cada percentual do data.map  

                //charData recebe os myLabels e mySeries criados no map acima
                setChartData({
                    labels: {
                        categories: myLabels
                    },
                    series: [
                        {
                            name: "% Success",
                            data: mySeries
                        }
                    ]
                });                              
                //console.log(chartData);                                   //busca a resposta escrita no charData usado para inspecionar no navegador manter como comentario
            });

    }, []);

    const options = {
        plotOptions: {
            bar: {
                horizontal: true,
            }
        },
    };


    //const mockData = {
    //    labels: {
    //        categories: ['Anakin', 'Barry Allen', 'Kal-El', 'Logan', 'Padmé']
    //    },
    //    series: [
    //        {
    //            name: "% Sucesso",
    //            data: [43.6, 67.1, 67.7, 45.6, 71.1]                   
    //        }
    //    ]
    //};

    return (
        <Chart
            options={{ ...options, xaxis: chartData.labels }}  //busca na mockData os labels, ...options é um acumulador do que o options já tem
            series={chartData.series}
            type="bar"
            height="240"
        />
    );
}

export default BarChart;