import NavBar from "@/components/NavBar";
import Button from "@/components/Button";
import { PlusCircleIcon } from '@heroicons/react/24/outline';

export default function Home() {
  return (
    <>
      <NavBar active={"home"} />

      <main className="flex flex-col p-4 items-center justify-center ">

        <div className="flex-grow p-4 m-10">
          <h2 className="text-2xl font-bold mb-4">Sobre Nós</h2>
          <p>
            A AgroSync é uma plataforma inovadora que oferece gestão inteligente de dados agrícolas para ajudar os agricultores a tomar decisões informadas baseadas em dados precisos, maximizando a qualidade da colheita e otimizando a eficiência operacional em até 30%.

            Com uma equipe experiente e um mercado em expansão, a AgroSync é uma oportunidade de investimento promissora no mercado agrícola brasileiro. Nossa plataforma coleta dados precisos sobre o clima e o solo, permitindo que os agricultores tomem decisões informadas sobre a irrigação e nutrição das plantas. Com a integração de dados, a plataforma ajuda os agricultores a otimizar suas operações agrícolas e alcançar uma maior produtividade. Além disso, a AgroSync oferece suporte e orientação personalizada de especialistas agrícolas em tempo real.

            Nosso objetivo é ajudar agricultores de todo o país a impulsionar a produtividade e a rentabilidade de seus negócios, oferecendo uma solução completa para gestão inteligente de dados agrícolas. Com nossa plataforma, você pode obter insights valiosos para tomar decisões estratégicas e impulsionar o crescimento no agronegócio.

            Na AgroSync, estamos comprometidos em transformar a forma como a agricultura é gerenciada, fornecendo aos agricultores as ferramentas necessárias para alcançar o sucesso em um mercado em constante mudança. Junte-se à AgroSync e descubra o poder dos dados agrícolas inteligentes para impulsionar o crescimento e o sucesso do seu negócio.
          </p>
        </div>
      </main>
    </>
  );
}