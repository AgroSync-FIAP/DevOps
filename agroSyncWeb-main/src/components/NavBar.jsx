import Link from "next/link";
import DropMenu from "./dropMenu";

export default function NavBar({ active }) {
    return (
        <nav className="bg-green-pea-800 h-20 px-8 flex justify-between items-center">
            <div className="flex">
                <Link href="/">
                    <img src="LogoCreme.svg" alt="Logo AgroSync" className="w-40 h-60" />
                </Link>
            </div>
            <ul className="flex space-x-40">
                <li className="flex w-600 justify-between items-start flex-shrink-0">
                    <Link
                        href="/analysisOfSoil"
                        className={`${active === "analysisOfSoil" ? "text-green-pea-50" : "text-green-pastel-dark"}`}
                    >
                        Analysis Of Soils
                    </Link>
                </li>
                {/* <li className="flex w-600 justify-between items-start flex-shrink-0">
                    <Link
                        href="/analysisOfImagens"
                        className={`${active === "analysisOfImagens" ? "text-creme" : "text-green-pastel"
                            }`}
                    >
                        analysisOfImagenss
                    </Link>
                </li> */}
                <li className="flex w-600 justify-between items-start flex-shrink-0">
                    <Link
                        href="/farm"
                        className={`${active === "farm" ? "text-green-pea-50" : "text-green-pastel-dark"}`}
                    >
                        Farm 
                    </Link>
                </li>
                <li className="flex w-600 justify-between items-start flex-shrink-0">
                    <Link
                        href="/analysisOfImages"
                        className={`${active === "analysisOfImages" ? "text-green-pea-50" : "text-green-pastel-dark"
                            }`}
                    >
                        Analysis Of Imagess
                    </Link>

                </li>
                <li className="flex w-600 justify-between items-start flex-shrink-0">
                    <Link
                        href="/login"
                        className={`${active === "login" ? "text-green-pea-50" : "text-green-pastel-dark"
                            }`}
                    >
                        Login
                    </Link>

                </li>
            </ul>
            <DropMenu/>
            {/* <div className="h-12 w-12 rounded-full overflow-hidden">
                <img src="https://i.pravatar.cc/100" alt="avatar do usuário" />
                <DropMenu/>
            </div> */}
        </nav>
    );
}
