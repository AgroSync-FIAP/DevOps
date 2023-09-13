import NavBar from "@/components/NavBar";
import SuplyChain from "@/app/suplyChain/page";


export default function Farm() {
  return (
    <>
      <NavBar active={"farm"} />

      <main className="green-pastel-light m-20 p-8">
        <h2> Farm</h2>
        <SuplyChain/>
      </main>
    </>
  )
}